package com.lyndir.masterpassword.gui.platform.mac;

import com.apple.eawt.*;
import com.lyndir.masterpassword.gui.GUI;
import com.lyndir.masterpassword.gui.PasswordFrame;
import com.lyndir.masterpassword.gui.User;

import javax.swing.*;


/**
 * @author lhunath, 2014-06-10
 */
public class AppleGUI extends GUI {

    public AppleGUI() {

        Application application = Application.getApplication();
        application.addAppEventListener( new AppForegroundListener() {

            @Override
            public void appMovedToBackground(AppEvent.AppForegroundEvent arg0) {
            }

            @Override
            public void appRaisedToForeground(AppEvent.AppForegroundEvent arg0) {
                open();
            }
        } );
        application.addAppEventListener( new AppReOpenedListener() {
            @Override
            public void appReOpened(AppEvent.AppReOpenedEvent arg0) {
                open();
            }
        } );
    }

    @Override
    protected PasswordFrame newPasswordFrame(final User user) {
        PasswordFrame frame = super.newPasswordFrame( user );
        frame.setDefaultCloseOperation( WindowConstants.HIDE_ON_CLOSE );

        return frame;
    }
}
