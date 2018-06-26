window.alert = function(){};
        var defaultCSS = document.getElementById('bootstrap-css');
        function changeCSS(css){
            if(css) $('head > link').filter(':first').replaceWith('<link rel="stylesheet" href="'+ css +'" type="text/css" />'); 
            else $('head > link').filter(':first').replaceWith(defaultCSS); 
        }
        $( document ).ready(function() {
          var iframe_height = parseInt($('html').height()); 
          window.parent.postMessage( iframe_height, 'https://bootsnipp.com');
        });
	
$(document).ready(function() {
    $('#visit').DataTable();
} );	


$(document).ready(function() {
    $('#visit1').DataTable();
} );
$(document).ready(function() {
    $('#visit2').DataTable();
} );
$(document).ready(function() {
    $('#visit3').DataTable();
} );


function updatedetails(id)
{
	var f4=document.form;
	f4.method="post";
	f4.action='update?id='+id;
	f4.submit();
	}


$(document).ready(function(){
	
	$('input[type=password]').keyup(function() {
		var pswd = $(this).val();
		
		//validate the length
		if ( pswd.length < 8 ) {
			$('#length').removeClass('valid').addClass('invalid');
		} else {
			$('#length').removeClass('invalid').addClass('valid');
		}
		
		//validate letter
		if ( pswd.match(/[A-z]/) ) {
			$('#letter').removeClass('invalid').addClass('valid');
		} else {
			$('#letter').removeClass('valid').addClass('invalid');
		}

		//validate capital letter
		if ( pswd.match(/[A-Z]/) ) {
			$('#capital').removeClass('invalid').addClass('valid');
		} else {
			$('#capital').removeClass('valid').addClass('invalid');
		}

		//validate number
		if ( pswd.match(/\d/) ) {
			$('#number').removeClass('invalid').addClass('valid');
		} else {
			$('#number').removeClass('valid').addClass('invalid');
		}
		
		//validate space
		if ( pswd.match(/[^a-zA-Z0-9\-\/]/) ) {
			$('#space').removeClass('invalid').addClass('valid');
		} else {
			$('#space').removeClass('valid').addClass('invalid');
		}
		
	}).focus(function() {
		$('#pswd_info').show();
	}).blur(function() {
		$('#pswd_info').hide();
	});
	
});


$(document).ready(function()                      
		{
	
		});

		function ondatechange()
		{
		
	    
			
		$.ajax({
			type: "post",
			url: 'HomeController',
			cache: false,
			data: $('#hello').serialize(),
			success: function(apttime)
			{
				try
				{
					$('#apttime').html(apttime);
				}
				catch(e)
				{
					alert(e);
				}
			}
		});
		}
		
		function ontimechange()
		{
		
	    
			
		$.ajax({
			type: "post",
			url: 'HomeController',
			cache: false,
			data: $('#apttime').serialize(),
			success: function(aptdoctor)
			{
				try
				{
					$('#aptdoctor').html(aptdoctor);
				}
				catch(e)
				{
					alert(e);
				}
			}
		});
		}

		setTimeout(function()
				{
					$('#myMessage1').fadeOut('fast');
				}, 2000);
		
		
		   $(function () {
               $('#datetimepicker1').datetimepicker(
               		{ minView: 2, picktime: false, format: 'yyyy-mm-dd', startDate: new Date(), onselect: ondatechange()});
           });