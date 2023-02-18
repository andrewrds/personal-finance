function createProvider() {
	let providerName = jQuery('#inputName').val();
	
    jQuery.post({
        url: 'http://localhost:8080/provider/create',
        data: { name: providerName },
        success: function(result) {
        }
    });
}