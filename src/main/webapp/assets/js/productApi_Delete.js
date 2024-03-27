/**
 * 상품검색
 */

document.querySelector('#delete').addEventListener('click', function() {
   const pcode = prompt('삭제할 상품 코드를 입력하세요.')

    
    //2. 입력값으로 자바스크립트 객체 생성(자바스크립트 객체는 미리 타입을 정의하지 않고 사용할수 있습니다.)
    
    //3.자바스크립트 객체를 json 전송을 위해 직렬화 (문자열로 변환)

   
   // post 요청
   const xhr = new XMLHttpRequest()      //비동기 통신 객체 생성
    xhr.open('POST','api/productss?pcode='+pcode)         //전송 보낼 준비 (url과 method)
    //전송할 데이터의 형식을 요청 헤더로 전달합니다.
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhr.send()            //요청 전송.POST는 페이로드가 있습니다.
    xhr.onload=function(){         //요청에 대한 응답받았을 때 onload 이벤트 생깁니다. onload 핸들러 함수
         console.log("post 응답 :",xhr.response)      //response 는 응답받은 내용을 저장한 프로퍼티
         const resultObj =JSON.parse(xhr.response)
        if(xhr.status === 200 || xhr.status ===201){        // readyState 가 DONE

           	 if(resultObj.result ===1){
					alert('상품삭제완료.')
				}
				if(resultObj.result ===0){
					alert('없는거다.')
				}
        }else {
   		console.error('오류1-',xhr.response)
        console.error('오류2-',xhr.status)
      }    
   }
})