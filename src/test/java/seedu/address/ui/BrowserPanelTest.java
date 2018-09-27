package seedu.address.ui;

import static guitests.guihandles.WebViewUtil.waitUntilBrowserLoaded;
import static org.junit.Assert.assertEquals;
import static seedu.address.testutil.EventsUtil.postNow;
<<<<<<< HEAD
import static seedu.address.testutil.TypicalRecords.ALICE;
=======
import static seedu.address.testutil.TypicalRecords.INDO;
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
import static seedu.address.ui.BrowserPanel.DEFAULT_PAGE;
import static seedu.address.ui.UiPart.FXML_FILE_FOLDER;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;

import guitests.guihandles.BrowserPanelHandle;
import seedu.address.MainApp;
import seedu.address.commons.events.ui.RecordPanelSelectionChangedEvent;

public class BrowserPanelTest extends GuiUnitTest {
    private RecordPanelSelectionChangedEvent selectionChangedEventStub;

    private BrowserPanel browserPanel;
    private BrowserPanelHandle browserPanelHandle;

    @Before
    public void setUp() {
<<<<<<< HEAD
        selectionChangedEventStub = new RecordPanelSelectionChangedEvent(ALICE);
=======
        selectionChangedEventStub = new RecordPanelSelectionChangedEvent(INDO);
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e

        guiRobot.interact(() -> browserPanel = new BrowserPanel());
        uiPartRule.setUiPart(browserPanel);

        browserPanelHandle = new BrowserPanelHandle(browserPanel.getRoot());
    }

    @Test
    public void display() throws Exception {
        // default web page
        URL expectedDefaultPageUrl = MainApp.class.getResource(FXML_FILE_FOLDER + DEFAULT_PAGE);
        assertEquals(expectedDefaultPageUrl, browserPanelHandle.getLoadedUrl());

        // associated web page of a record
        postNow(selectionChangedEventStub);
<<<<<<< HEAD
        URL expectedRecordUrl = new URL(BrowserPanel.SEARCH_PAGE_URL + ALICE.getName().fullName.replaceAll(" ", "%20"));
=======
        URL expectedRecordUrl = new URL(BrowserPanel.SEARCH_PAGE_URL + INDO.getName().fullName.replaceAll(" ", "%20"));
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e

        waitUntilBrowserLoaded(browserPanelHandle);
        assertEquals(expectedRecordUrl, browserPanelHandle.getLoadedUrl());
    }
}
