function createProvider() {
	let providerName = jQuery('#inputName').val();
	
    jQuery.post({
        url: '/provider/create',
        data: { name: providerName },
        success: function(result) {
            location.reload();
        }
    });
}

function deleteProvider(providerName) {
    jQuery.post({
        url: '/provider/delete',
        data: { name: providerName },
        success: function(result) {
            location.reload();
        }
    });
}

function createAccount() {
    let providerName = jQuery('#providerName').attr('value');
    let accountName = jQuery('#inputName').val();
    
    jQuery.post({
        url: '/account/create',
        data: { providerName: providerName, accountName: accountName },
        success: function(result) {
            location.reload();
        }
    });
}

function deleteAccount(accountName) {
    let providerName = jQuery('#providerName').attr('value');
    
    jQuery.post({
        url: '/account/delete',
        data: { providerName: providerName, accountName: accountName },
        success: function(result) {
            location.reload();
        }
    });
}