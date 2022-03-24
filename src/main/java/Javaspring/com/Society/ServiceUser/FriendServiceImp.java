package Javaspring.com.Society.ServiceUser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Javaspring.com.Society.Converter.FriendConverter;
import Javaspring.com.Society.DTO.FriendDTO;
import Javaspring.com.Society.DTO.UserDTO;
import Javaspring.com.Society.Entities.FriendEntity;
import Javaspring.com.Society.Entities.UserEntity;
import Javaspring.com.Society.Repository.FriendRepository;
import Javaspring.com.Society.Repository.UserRepository;

@Service
public class FriendServiceImp implements FriendService{
	@Autowired
	private FriendRepository friendRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FriendConverter friendConverter;
	
	@Transactional
	public FriendDTO save(FriendDTO friendModel) {
		UserEntity source = userRepository.findOneById(friendModel.getSourceId());
		UserEntity target = userRepository.findOneById(friendModel.getTargetId());
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		FriendEntity friendEntity =  new FriendEntity();
		friendEntity.setCreateAt(date);
		friendEntity.setSource(source);
		friendEntity.setTarget(target);
		friendEntity.setStatus(friendModel.getStatus());
		if(friendModel.getId() != 0) {
			friendEntity.setId(friendModel.getId());
		}
		
		return friendConverter.toModel(friendRepository.save(friendEntity));
	}
	@Transactional
	public List<FriendDTO> findAll(FriendDTO friendModel) {
		List<FriendDTO> listModel = new ArrayList<FriendDTO>();
		List<FriendEntity> listEntity = friendRepository.findAll();
		for(FriendEntity item : listEntity) {
			FriendDTO model = friendConverter.toModel(item);
			listModel.add(model);
		}
		return listModel;
	}
	@Transactional
	public List<FriendDTO> findAllBySource(long id) {
		List<FriendDTO> listModel = new ArrayList<FriendDTO>();
		List<FriendEntity> listEntity = friendRepository.findAllBySource_id(id);
		for(FriendEntity item : listEntity) {
			FriendDTO model = friendConverter.toModel(item);
			listModel.add(model);
		}
		return listModel;
	}
	@Transactional
	public List<FriendDTO> findAllByTarget(long id) {
		List<FriendDTO> listModel = new ArrayList<FriendDTO>();
		List<FriendEntity> listEntity = friendRepository.findAllByTarget_id(id);
		for(FriendEntity item : listEntity) {
			FriendDTO model = friendConverter.toModel(item);
			listModel.add(model);
		}
		return listModel;
	}
	@Override
	@Transactional
	public void deleteById(long idFriend, long idUser) {
		
		List<FriendDTO> source = findAllBySource(idUser);
		List<FriendDTO> target = findAllByTarget(idUser);
		FriendDTO delete = new FriendDTO();
		
		
			
			for(int s =0; s<source.size();s++ ) {
				FriendDTO sx = source.get(s);
				if(idFriend == sx.getTargetId() ) {
					delete = sx;
				}
				
			}
			for(int t =0; t  < target.size();t++ ) {
				FriendDTO tx = target.get(t);
				if(idFriend == tx.getSourceId() ) {
					delete = tx;
				}
			}

		
		friendRepository.deleteById(delete.getId());
	}



}
