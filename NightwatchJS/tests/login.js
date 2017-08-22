exports.command = function() {
    return this.perform(function () {	
		this
			.url('https://staging.cmdapp.com/cms')
			.pause(1000)
			.setValue('input#ctl00_mainContent_LoginCtrl_UserName', '****')
			.setValue('input#ctl00_mainContent_LoginCtrl_Password', '****')
			.pause(1000)
			.click("#ctl00_mainContent_LoginCtrl_Login");
	});

};