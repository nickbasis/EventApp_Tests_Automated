// Notes module tests



// 1. Click create note button
// - new note button should be disabled
// - new "untitled, unsaved" should appear in left
// - textarea should say "tap here to write"
// - "last saved" date should say "unsaved"
// - save button should be disabled
// - delete button should be enabled

// 2. Enter text in textarea
// - save button should be enabled
// - create note button should be disabled

// 3. Save
// - notification should appear
// - last saved should be "a few seconds ago"
// - note title should be displayed on left, with current datetime as save timestamp
// - create note button should be enabled

// 4. Save another note (repeat steps 1-3 but no assertions needed)

// 5. Select first (older) note
// - it should load in text area
// - its last saved date should be displayed
// - save button should be disabled
// - create note button should be enabled

// 6. Edit textarea
// - save button should be enabled
// - create button should be enabled

// 7. Save
// - same assertions as step 3
// - edited note should be sorted to top of list on left

// 8. Delete first note
// - confirm dialog should appear
// Confirm by clicking "yes"
// - notification should appear
// - the note should disappear from left list
// - the first note in list should be opened in textarea
// - save button should be disabled
// - create button should be enabled

// 9. Delete all notes
// - create note button should be enabled
// - "no notes yet" should be displayed
// - save button should be disabled
// - delete button should be disabled

module.exports = {
	
	'Notes module' : function (browser) {
		browser.appLogin();
		browser.pause(1000);  // Give notification dialog time to appear
		
		// Check if a High Importance Dialog is open and close it
		browser.element('css selector',".modal-header .close", function(highdialog){
			if(highdialog.value && highdialog.value.ELEMENT){
				
				browser.click(".modal-header .close");
				browser.log('Closing the notification dialog and moving on...'.red);
				browser.pause(1500);  // Give notification dialog time to disappear
				
			} else {				
				browser.log('No notification dialog! Moving on!'.green);
			}
		});

		// 0. Open notes module
		browser
			.waitForElementVisible('.nav-item-notes', 5000)
			.click('.nav-item-notes a')
			.waitForElementVisible('.page-title', 2000)
			.expect.element('.page-title span').text.to.equal('Notes');
		
		// 1. Click create note button
		// - textarea should say "tap here to write"
		// - "last saved" date should say "unsaved"
		// - save button should be disabled
		// - delete button should be enabled
		browser
			.click('a.newNote');
		browser.pause(1000);
		
		browser.expect.element('.note-items :first-child .subject').text.to.equal('Untitled');
		browser.expect.element('.note-items :first-child .updated').text.to.equal('Unsaved');
		browser.expect.element('textarea').to.have.attribute('placeholder','Tap here to write...');
		browser.log('Text area is there...'.green);
		browser.expect.element('.lastSaved').text.to.not.contain('Invalid');
		browser.assert.cssClassPresent(".saveNote", "disabled");
		//browser.log('Save button is disabled'.green);
		browser.expect.element('.deleteNote').to.be.enabled;
		//browser.expect.element('.deleteNote').to.not.have.attribute('class','disabled');
		browser.assert.cssClassPresent("a.newNote", "disabled");
		browser.pause(1000);
		
		// 2. Enter text in textarea
		// - save button should be enabled
		// - create note button should be disabled
		// - If text area is not enabled, click the 'new note' button
		
		browser.element('css selector',".the-note .needsclick", function(textfield){
			
			if(textfield.value && textfield.value.ELEMENT != 1){
				
				browser.click(".btn-lg");
			}
		
		});
		
		var text = "This is a note";
		var text2 = "This is another note";
		
		browser.log('Lets create a note'.green);
		browser.click(".the-note .needsclick");
		browser.pause(500);
		browser.setValue('.the-note .needsclick', text);
		browser.pause(500);
		browser.click(".the-note .needsclick");
		browser.pause(1500);
		browser.assert.cssClassNotPresent(".fr-bttn.saveNote", "disabled");
		browser.assert.cssClassPresent("a.newNote", "disabled");
		browser.pause(500);
		
		// 3. Save
		// - notification should appear
		// - last saved should be "a few seconds ago"
		// - note title should be displayed on left, with current datetime as save timestamp
		// - create note button should be enabled
		let now = new Date();
		let hours = now.getHours();
		if (hours > 12) {
			
			hours = hours - 12;
		}
		let ourTimeString = 'Today at ' + hours;
		browser.log(ourTimeString);
		
		
		
		browser.click(".fr-bttn.saveNote");
		browser.pause(2500);
		//browser.assert.elementPresent("div[role='alert']");
		browser.waitForElementVisible('div[role="alert"]');
		browser.click('div[role="alert"]');
		browser.expect.element('.lastSaved').text.to.contain('a few seconds ago');
		browser.assert.containsText(".subject", text);
		browser.assert.cssClassNotPresent("a.newNote", "disabled");
		browser.assert.containsText(".note-items li:nth-child(1) .updated", ourTimeString);
		
		
		// 4. Save another note (repeat steps 1-3 but no assertions needed)
		browser.log('Lets create another note'.green);
		browser.pause(1000);
		browser.click("a.newNote");
		browser.pause(500);
		browser.click(".the-note .needsclick");
		browser.pause(500);
		browser.setValue('.the-note .needsclick', text2);
		browser.pause(500);
		browser.click(".the-note .needsclick");
		browser.pause(2000);
		browser.click(".fr-bttn.saveNote");
		browser.waitForElementVisible('div[role="alert"]');
		browser.click('div[role="alert"]');
		browser.pause(2000);
		
		// 5. Select first (older) note
		// - it should load in text area
		// - its last saved date should be displayed
		// - save button should be disabled
		// - create note button should be enabled
		
		browser.click(".note-items li:nth-child(2)");
		browser.pause(3500);
		browser.expect.element(".the-note .needsclick").to.have.value.that.equals(text);
		browser.pause(1500);
		browser.assert.elementPresent(".updated");
		browser.pause(1500);
		browser.assert.cssClassPresent(".fr-bttn.saveNote", "disabled");
		browser.assert.cssClassNotPresent("a.newNote", "disabled");
		
		browser.pause(10000);
		
		
		browser.end();
	}
}