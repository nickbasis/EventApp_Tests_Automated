module.exports = {
	'Notifications Test' : function (browser) {
		browser
			.login();
		
		browser.waitForElementVisible('.icons8-remote-control', 2000);
		
		browser
			.click(".icons8-remote-control")
			.pause(1000)
			.assert.title("Remote", "The title is Remote! HA!")
			.click("a[href='#page-notify']")
			.pause(2000);

		var text;
		
		//Send the notification
		for(let i=1;i<=3;i++) {
			if (i==1) {
				text = "Low notification";	
			} else if (i == 2) {
				text = "Medium notification";
			} else {
				text = "High notification";
			}
				
			browser
				.click(".notification-priority-group :nth-child("+ i +")")
				.setValue('#notification-message', text)
				.pause(2000)
				.click(".btn-success")
				.pause(2000)
				.acceptAlert()
				.pause(2000)
				.assert.containsText(".notifications-prior-list :nth-child(1) .message", text)
				.pause(2000);
		}


		browser.end();

	}
}