   
function like_on() {
  var re_no = document.getElementById("re_no").value;

  $.ajax({
      url : "review_show",
      type: 'POST',
      data: { re_no : re_no, type : "likeon"  },
      //dataType: "int",

      success: function(data) {
			
			var reviewHtml = "<p class='helpBtn'><input type='button' value='도움되었습니다' onclick='like_off()' class='like_on'></p>";
			var likeHtml = "이 리뷰가 도움이 된 횟수 <span class='font_green'>" + data + "</span>";
			
			
			$('#btnBox').html(reviewHtml);
			$('#likeCount').html(likeHtml);

      },
      error:function (request,status,errorData) {
          alert('error code: ' + request.status + "\n"
                  + 'message: ' + request.responseText + "\n"
                  + 'error: ' + errorData);
      }
     });
  }
	
function like_off() {
	var likeoff = confirm("관심 등록을 취소하시겠습니까?");
	if (likeoff) {
		var re_no = document.getElementById("re_no").value;

		  $.ajax({
		      url : "review_show",
		      type: 'POST',
		      data: { re_no : re_no, type : "likeoff"  },
		      //dataType: "int",
		
		      success: function(data) {
		      
		      //alert("해당 게시글의 관심 등록을 취소하였습니다.");
		      
			    var reviewHtml = "<p class='helpBtn'><input type='button' value='도움 되었나요?' onclick='like_on()' ></p>";
				var likeHtml = "이 리뷰가 도움이 된 횟수 <span class='font_green'>" + data + "</span>";
				
			
			$('#btnBox').html(reviewHtml);
			$('#likeCount').html(likeHtml);
		          
		      },
		      error:function (request,status,errorData) {
		          alert('error code: ' + request.status + "\n"
		                  + 'message: ' + request.responseText + "\n"
		                  + 'error: ' + errorData);
		      }
		     });
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	