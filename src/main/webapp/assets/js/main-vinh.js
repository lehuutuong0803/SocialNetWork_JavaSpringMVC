$(document).ready(function(){
    $('#image').change(function(){
        $("#frames").html('');
        for (var i = 0; i < $(this)[0].files.length; i++) {
            $("#frames").append('<img src="'+window.URL.createObjectURL(this.files[i])+'" width="100px" height="100px"/>');
        }
    });
});

const money = document.querySelector(".prise");
money.toLocaleString('en-US',
  {style: 'currency', currency: 'USD'}
);


function commaSeparateNumber(val){
    while (/(\d+)(\d{3})/.test(val.toString())){
      val = val.toString().replace(/(\d+)(\d{3})/, '$1'+','+'$2');
    }
    return val;
  }
$('.prise').focusout(function(){

  alert(commaSeparateNumber($(this).val()));
});

$('#price').priceFormat();