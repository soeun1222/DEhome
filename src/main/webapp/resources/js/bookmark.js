function bm_on() {
  var tip_no = document.getElementById("tip_no").value;
  console.log(tip_no);
  $.ajax({
      url : "interiorTipPage",
      type: 'POST',
      data: { tip_no : tip_no, type : "bmOn"  },

      success: function(data) {
			
			var bookmarkHtml = "<input type='button' class='bm_on' onclick='bm_off()'>";
			var bmHtml = "" + data + "";
				
			
			$('#bmBtn').html(bookmarkHtml);
			$('#bmCount').html(bmHtml);

      },
      error:function (request,status,errorData) {
          alert('error code: ' + request.status + "\n"
                  + 'message: ' + request.responseText + "\n"
                  + 'error: ' + errorData);
      }
     });
  }
	
function bm_off() {
	var bmoff = confirm("북마크를 해제하시겠습니까?");
	if (bmoff) {
		var tip_no = document.getElementById("tip_no").value;

		  $.ajax({
		      url : "interiorTipPage",
		      type: 'POST',
		      data: { tip_no : tip_no, type : "bmOff"  },
		
		      success: function(data) {
		      
					var bookmarkHtml = "<input type='button' onclick='bm_on()'>";
					var bmHtml = "" + data + "";
						
					
					$('#bmBtn').html(bookmarkHtml);
					$('#bmCount').html(bmHtml);
		          
		      },
		      error:function (request,status,errorData) {
		          alert('error code: ' + request.status + "\n"
		                  + 'message: ' + request.responseText + "\n"
		                  + 'error: ' + errorData);
		      }
		     });
	}
}