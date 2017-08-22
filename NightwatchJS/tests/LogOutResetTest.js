module.exports = {
	'Log Out Reset Test' : function (browser) {
		browser
			.login();
		
		browser.waitForElementVisible('.icons8-remote-control', 2000);

		browser
			.click(".icons8-remote-control")
			.pause(1000)
			.assert.title("Remote", "The title is Remote! HA!")
			.pause(2000);
		
		
		
		for(let i=1;i<=3;i++) {
			
			browser.perform(function() {
				console.log('Loop'.cyan, i); //cyan
			});
				
			browser
			
				.click("a[href='#page-advanced']")
				.click("div[data-command='login']")  // Click Login button
				.pause(3000)
				.click("a[href='#page-devices']");
				
			browser.expect.element("a[href='#commands']").to.be.present; //Make sure we are in the 'Devices'
			browser.expect.element("div[data-command='logout']").to.be.present.and.text.to.contain('Log');
			browser.expect.element("div[data-command='restart']").to.be.present.and.text.to.contain('Restart');
				
			browser
			
				.click("div[data-command='logout']") // Log Out
				.pause(3000)
				.click("div[data-command='restart']") //Restart
				.pause(3000)
				.acceptAlert()
				.pause(2000);
				
		}
			browser
				.click("div[data-command='reset']") //Reset
						.pause(2000)
						.acceptAlert()
						.pause(2000);
		
			
		browser.end();

	}
}


