package Javaspring.com.Society.UserController;

import java.util.Arrays;
import java.text.Normalizer;
import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class BaseController {
	public ModelAndView _mvShare = new ModelAndView();
	
	

	    	public static String unAccent(String s) {
	    	        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
	    	        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	    	        return pattern.matcher(temp).replaceAll("");
	    	}
	    	
	

}
