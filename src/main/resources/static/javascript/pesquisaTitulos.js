
$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event) {
	
	debugger;
	var button = $(event.relatedTarget);
	var codigo = button.data("codigo");
	var descricao = button.data("descricao");
	
	var model = $(this);
	var form = model.find('form')
	var action = form.data('url');
	
	if(!action.endsWith('/')){
		action += '/';
	}
	form.attr('action', action + codigo);
	model.find('.modal-body span').html('Tem certeza que deseja apagar o titulo <strong>'+ descricao + '</strong> ?')
	
});

