module.exports = {
	'Pages and Dialogs' : function (browser) {
		browser
			.login();
		
		browser.waitForElementVisible('.icons8-remote-control', 2000);
		
		browser
			.click(".icons8-remote-control")
			.pause(1000)
			.assert.title("Remote", "The title is Remote! HA!")
			.click("a[href='#page-goto']")
			.pause(2000);
			
		//browser.assert.elementPresent("a[href='#pages']");
		
		//Check if Pages tab is present, if yes then click it
		
		browser.element('css selector',"a[href='#pages']", function(pageselement){
			if(pageselement.value && pageselement.value.ELEMENT){
				
				browser.pause(1000);
				browser.click("a[href='#pages']");
				browser.log('Pages tab is there!'.green);
					
			} else {
				
				browser.log('Pages does not exist'.red);
			}
		});
		
		
		//Print the name of each Page and then click
		
		browser.elements('css selector',"#pages .button-list.module-list li", function(pageslist){
			
			browser.log(pageslist.value.length + ' items found:');
			
			browser.perform(function() {
			
				 for (let i=1;i<=pageslist.value.length;i++) {
					
					browser.getText('#pages :nth-child('+i+') div', function(text){
						browser.log('- ' + text.value);
					});
					
					browser.click('#pages :nth-child('+i+')');
					
					browser.pause(1500);
					
				} 
			
			});

			
		});
		
	

			
		browser.end();

	}
}