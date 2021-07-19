var more = -1;
$(function(){$('#more').on('click',function(){
	var path = document.getElementById("path").value;
	more = more + 1
		$.ajax({
			url : "used_trade",
			type : "post",
			data: { more : more},	
			dataType: "json",
			success: function(data) {
				var addListHtml = "";
				for(var i in data.list) {
					addListHtml += "<div class='used_post' onclick='location.href=\'tradeShow\''>";	
					addListHtml += "<div class='post_image_div'>";	
					addListHtml += "<img class='post_image' src='" + path + data.list[i].tr_photo + "'/>";	
					addListHtml += "</div>";	
					addListHtml += "<div class='post_content_div'>";	
					addListHtml += "<p class='post_title'>" + data.list[i].tr_title+ "</p>";	
					addListHtml += "<p class='post_address'>" + data.list[i].user_addr2+ "</p>";	
					addListHtml += "if(" + data.list[i].tr_price + " == 0){";	
					addListHtml += "<div class='price_heart'>";	
					addListHtml += "<p class='post_price'>무료나눔</p>";	
					addListHtml += "if(" +data.list[i].tr_count +"!= 0){";	
					addListHtml += "<div class='heart_img_div'>";	
					addListHtml += "<img src='" + path + "/resources/images/heart.png' class='heart' />";	
					addListHtml += "<span class='heart_cnt'>"+ data.list[i].tr_count+"</span>";	
					addListHtml += "</div>";	
					addListHtml += "}";	
					addListHtml += "</div>";	
					addListHtml += "} else {";	
					addListHtml += "<div class='price_heart'>";	
					addListHtml += "<p class='post_price'>" + data.list[i].tr_price + "</p>";	
					addListHtml += "if(" +data.list[i].tr_count +"!= 0){";	
					addListHtml += "<div class='heart_img_div'>";	
					addListHtml += "<img src='" + path + "/resources/images/heart.png' class='heart' />";	
					addListHtml += "<span class='heart_cnt'>"+ data.list[i].tr_count+"</span>";	
					addListHtml += "</div>";	
					addListHtml += "}";	
					addListHtml += "</div>";	
					addListHtml += "}";	
					addListHtml += "</div>";	
					addListHtml += "</div>";	
				}
				if(data.list.length >= 1) {
                  $("#used_post_box").append($(addListHtml).fadeIn());
             	} else {
            	  //$("#move_btn").css('display','none'); -> 한번 더 클릭해야 사라진다
                  alert("다음페이지가 없습니다.");
              	}
			},
			error:function (request,status,errorData) {
              alert('error code: ' + request.status + "\n"
                      + 'message: ' + request.responseText + "\n"
                      + 'error: ' + errorData);
          	}
		})
	})
});