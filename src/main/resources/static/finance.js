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

function deleteProvider(providerId) {
    jQuery.post({
        url: '/provider/delete',
        data: { id: providerId },
        success: function(result) {
            location.reload();
        }
    });
}

function createAccount() {
    let providerId = jQuery('#providerId').attr('value');
    let accountName = jQuery('#inputName').val();
    
    jQuery.post({
        url: '/account/create',
        data: { providerId: providerId, accountName: accountName },
        success: function(result) {
            location.reload();
        }
    });
}

function deleteAccount(accountId) {
    let providerId = jQuery('#providerId').attr('value');
    
    jQuery.post({
        url: '/account/delete',
        data: { providerId: providerId, accountId: accountId },
        success: function(result) {
            location.reload();
        }
    });
}