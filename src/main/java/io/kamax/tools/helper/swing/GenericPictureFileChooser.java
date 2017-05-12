/*
 * Hyperbox - Virtual Infrastructure Manager
 * Copyright (C) 2013 Maxime Dor
 * 
 * http://kamax.io/hbox/
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package io.kamax.tools.helper.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GenericPictureFileChooser {

    private MouseWorker mouseWorker;
    private Action a;

    public GenericPictureFileChooser(Component c) {
        mouseWorker = new MouseWorker();
        c.addMouseListener(mouseWorker);
    }

    public void setAction(Action a) {
        this.a = a;
    }

    private class MouseWorker extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            a.actionPerformed(null);
        }

    }

}
