

$.fn.dataTable.Api.register( 'column().data().sum()', function () {
    return this.reduce( function (a, b) {
        var x = parseFloat( a ) || 0;
        var y = parseFloat( b ) || 0;
        return x + y;
    } );
} );
 
/* Init the table and fire off a call to get the hidden nodes. */
$(document).ready(function() {
    var table = $('#estudiosList').DataTable();
    function filterColumn ( i ) {
        $('#estudiosList').DataTable().column( i ).search(
            $('#col'+i+'_filter').val(),
            $('#col'+i+'_regex').prop('checked'),
            $('#col'+i+'_smart').prop('checked')
        ).draw();
    }
    
    $(document).ready(function() {
    	 var tabla = $('#estudiosList').DataTable();
    	 $('input.column_filter').on( 'keyup click', function () {
    	        filterColumn( $(this).parents('span').attr('data-column') );
    	        $("#totalEstudio").text(table.column( 8, {page:'current'} ).data().sum());
    	    } );
    	    
    	    var tot = tabla.column(8).data().sum();
        $("#totalPendiente").text(tot);
    });
    
  } );
	
$(document).ready(function (){
    var table = $('#estudiosList').DataTable();
    
    $('#radiologo-filter').on('change', function(){
    	var val = $(this).val(); 
    	 table.column(12)
         .search( val ? '^'+$(this).val()+'$' : val, true, false )
         .draw();
    });
    
});
$(document).ready(function (){
    var table = $('#estudiosList').DataTable();
    
    $('#tipo_estudio-filter').on('change', function(){
    	var val = $(this).val(); 
    	 table.column(6)
         .search( val ? '^'+$(this).val()+'$' : val, true, false )
         .draw();
    });
    
});
$(document).ready(function (){
    var table = $('#estudiosList').DataTable();
    
    $('#centro_asis-filter').on('change', function(){
    	var val = $(this).val(); 
    	 table.column(1)
         .search( val ? '^'+$(this).val()+'$' : val, true, false )
         .draw();
    });
    
});	
