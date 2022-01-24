let index={
    init:function(){
        $("#btn-board-save").on("click",()=>{ //function(){}, ()=> this를 바인딩 하기 위해서
            this.save();
        }),
        $("#btn-board-delete").on("click",()=>{
                this.delteById();
        });

    },

    save:function (){
        let data = {
            title:$("#title").val(),
            content:$("#content").val(),
        };
        // console.log(data);
       $.ajax({
            type:"POST",
            url:"/api/board",
            data:JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType:"json"
        }).done(function(resp){
            alert("글쓰기가 완료되었습니다.");
            //console.log(resp);
            location.href = "/";
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },
    delteById:function (){
        var id = $("#id").text();
        $.ajax({
            type:"DELETE",
            url:"/api/board/"+id,
            dataType:"json"
        }).done(function(resp){
            alert("삭제가 완료되었습니다.");
            //console.log(resp);
            location.href = "/";
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    }
}

index.init();