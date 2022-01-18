let index={
    init:function(){
        $("#btn-save").on("click",()=>{ //function(){}, ()=> this를 바인딩 하기 위해서
            this.save();
        });
        $("#btn-login").on("click",()=>{
            this.login();
        });
    },

    save:function (){
        // alert('user save함수호출')
        let data = {
            username:$("#username").val(),
            password:$("#password").val(),
            email:$("#email").val()
        };
        // console.log(data);

        //ajax호출 시 default가 비동기 호출
        //ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청
       $.ajax({ //회원가입 수행요청(100초 가정)
            type:"POST",
            url:"/api/user",
            data:JSON.stringify(data), //http body 데이터
            contentType:"application/json; charset=utf-8",
            dataType:"json" //요청을 서버로 해서 응답이 왔을 때 기본적으로 모든 것이 문자열(생긴게 json이라면)=> javascript 오브젝트로
        }).done(function(resp){
            alert("회원가입이 완료되었습니다.");
            //console.log(resp);
            location.href = "/";
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },
    login:function (){
        // alert('user save함수호출')
        let data = {
            username:$("#username").val(),
            password:$("#password").val(),
        };
        // console.log(data);

        //ajax호출 시 default가 비동기 호출
        //ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청
        $.ajax({ //회원가입 수행요청(100초 가정)
            type:"POST",
            url:"/api/user/login",
            data:JSON.stringify(data), //http body 데이터
            contentType:"application/json; charset=utf-8",
            dataType:"json" //요청을 서버로 해서 응답이 왔을 때 기본적으로 모든 것이 문자열(생긴게 json이라면)=> javascript 오브젝트로
        }).done(function(resp){
            alert("로그인이 완료되었습니다.");
            //console.log(resp);
            location.href = "/";  //완료되면 여기로 이동
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    }
}

index.init();