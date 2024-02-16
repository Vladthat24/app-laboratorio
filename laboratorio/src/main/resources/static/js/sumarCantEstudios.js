 $(document).ready(function(){
        var tabla = $("#estudiosList").DataTable({
               
        });

        //1era forma para sum()
        var tot = tabla.column(10).data().sum();
        $("#total").text(tot);
    });