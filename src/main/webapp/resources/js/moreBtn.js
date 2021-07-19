var more = -1;
    
    //업체 리스트 더보기
    $(function(){$('#more').on('click',function(){
      more = more + 1;
      var path = document.getElementById("path").value;
      var popup_addr1 = document.getElementById("popup_addr1").value;
	  var popup_addr2 = document.getElementById("popup_addr2").value;
	  //아래는 임시 이미지 경로용 변수
	  var imgPath = document.getElementById("imgPath").value;
      console.log(more);
		
      $.ajax({
          url : "interiorList",
          type: 'POST',
          data: { more : more, paddr1 : popup_addr1, paddr2 : popup_addr2 },
          dataType: "json",

          success: function(data) {
              var addListHtml = "";
              for(var i in data.list) {
            	  addListHtml += "<div class='company_box'>";
                  addListHtml += "<a href='company_page?name=" + decodeURIComponent(data.list[i].com_name) + "'>";
                  addListHtml += "<div id='shop'>";
                  addListHtml += "<div class='shop_img'>";
                  addListHtml += "<img src='" + path + data.list[i].com_file + "' />";
                  addListHtml += "</div>";
                  addListHtml += "<div class='shop_ex'>";
                  addListHtml += "<div class='star'>";
                  addListHtml += "<img src='" + imgPath + "/images/star_green.png' />";
                  addListHtml += "<span>" + parseFloat(data.list[i].com_rating) + "</span>";
                  addListHtml += "</div>";
                  addListHtml += "<div class='shop_name'>" + decodeURIComponent(data.list[i].com_name) + "</div>";
                  addListHtml += "<p>" + decodeURIComponent(data.list[i].com_addr) + "</p>";
                  addListHtml += "<p>";
                  addListHtml += "<span>업체 리뷰";
                  addListHtml += "<span class='shop_count font_green font_bolder'>" + data.list[i].re_count + "건</span>";
                  addListHtml += "</span>";
                  addListHtml += "<span>최근 계약";
                  addListHtml += "<span class='shop_count font_green font_bolder'>" + data.list[i].com_contract + "건</span>";
                  addListHtml += "</span>";
                  addListHtml += "</p>";
                  addListHtml += "</div>";
                  addListHtml += "</div>";
                  addListHtml += "</a>";
                  addListHtml += "</div>";
              }
              if(data.list.length >= 1) {
                  $("#company_total_box").append($(addListHtml).fadeIn());
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
      	});
	  });
	});
	
	var total = 0;
	//업체 리뷰 리스트 더보기
	$(function(){$('#moreReList').on('click',function(){
      more = more + 1;
      var path = document.getElementById("path").value;
      var com_name = document.getElementById("com_name").value;
      var com_re_count = document.getElementById("com_re_count").value;
      
      console.log("REVIEW MORE");
      console.log(more);
      console.log(total);
      console.log("-------")

      $.ajax({
          url : "company_page",
          type: 'POST',
          data: { more : more, com_name : com_name, type : "re" },
          dataType: "json",

          success: function(data) {
              var moReListHtml = "";
              
              total += data.moRelist.length;
              
              for(var i in data.moRelist) {
              	
              	moReListHtml += "<a href='review_show?re_no=" + data.moRelist[i].re_no + "'>";
              	moReListHtml += "<div class='recon_01'>";
              	moReListHtml += "<p class='like'>";
              	moReListHtml += "<input type='button' value='" + data.moRelist[i].re_interest + "번 도움됨'>";
              	moReListHtml += "<span>" + decodeURIComponent(data.moRelist[i].user_nick) + "</span>";
              	moReListHtml += "</p>";
              	moReListHtml += "<p>" + decodeURIComponent(data.moRelist[i].re_content) + "</p>";
              	moReListHtml += "<img src='" + path + data.moRelist[i].re_file + "' />";
              	moReListHtml += "</div>";
              	moReListHtml += "</a>";

              }
              
              if(data.moRelist.length >= 1) {
                  $("#review_content_more").append($(moReListHtml).fadeIn());
              } else {
                  alert("다음페이지가 없습니다.");
              }
              
              if(total + 2 == com_re_count) {
              	$('#moreReList').css({"display":"none"});
              	$('#removeReList').css({"display":"block"});
              	
              }
              
              $('#removeReList').on('click',function(){
					$("#review_content_more").empty();

              		total = 0;
              		more = -1;
              		
              		$('#moreReList').css({"display":"block"});
              		$('#removeReList').css({"display":"none"});

				});
				
          },
          error:function (request,status,errorData) {
              alert('error code: ' + request.status + "\n"
                      + 'message: ' + request.responseText + "\n"
                      + 'error: ' + errorData);
          }
      	});
	  });
	});
	
	var exmore = -1;
	var extotal = 0;
	//업체 사례 리스트 더보기
	$(function(){$('#moreExList').on('click',function(){
      exmore = exmore + 1;
      var path = document.getElementById("path").value;
      var com_name = document.getElementById("com_name").value;
      var com_contract = document.getElementById("com_contract").value;
      
      console.log("EXAMPLE MORE");
      console.log(exmore);
      console.log(extotal);
      

      $.ajax({
          url : "company_page",
          type: 'POST',
          data: { more : exmore, com_name : com_name, type : "ex" },
          dataType: "json",

          success: function(data) {
              var moExListHtml = "";
              
              extotal += data.moExlist.length;
              
              console.log("데이터 길이 더한 extotal");
              console.log(extotal);
              console.log("-------");
              
              for(var i in data.moExlist) {
              
              	moExListHtml += "<a href='interior/cons_case?ex_no=" + data.moExlist[i].ex_no + "' style='display: inline-block;'>";
              	moExListHtml += "<div>";
              	moExListHtml += "<img src='" + path + data.moExlist[i].ex_file + "' />";
              	moExListHtml += "</div>";
              	moExListHtml += "<p>" + decodeURIComponent(data.moExlist[i].ex_title) + "</p>";
              	moExListHtml += "</a>";

              }
              
              if(data.moExlist.length >= 1) {
                  $("#cons_content_more").append($(moExListHtml).fadeIn());
              } else {
                  alert("다음페이지가 없습니다.");
              }
              
              if(extotal + 3 == com_contract) {
              	$('#moreExList').css({"display":"none"});
              	$('#removeExList').css({"display":"block"});
              	
              }
              
              $('#removeExList').on('click',function(){
					$("#cons_content_more").empty();

              		extotal = 0;
              		exmore = -1;
              		
              		$('#moreExList').css({"display":"block"});
              		$('#removeExList').css({"display":"none"});

				});
				
          },
          error:function (request,status,errorData) {
              alert('error code: ' + request.status + "\n"
                      + 'message: ' + request.responseText + "\n"
                      + 'error: ' + errorData);
          }
      	});
	  });
	});
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	