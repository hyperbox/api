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
import javax.swing.table.TableModel;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


public class JTableImp extends JTable implements FocusListener {

    private static final long serialVersionUID = 717736072775935740L;
    private Boolean clearOnFocusLost = true;

    public JTableImp(TableModel m) {
        super(m);
        init();
    }

    private void init() {
        addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        // not used
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getOppositeComponent() instanceof JTable) {
            if (clearOnFocusLost) {
                clearSelection();
            }
        }
    }

}
