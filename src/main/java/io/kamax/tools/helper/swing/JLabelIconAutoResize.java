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


public class JLabelIconAutoResize extends JLabel {

    private static final long serialVersionUID = 3623948011238072783L;

    public JLabelIconAutoResize() {
        super();
        setMinimumSize(new Dimension(1, 1));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponents(g);

        ImageIcon icon = (ImageIcon) getIcon();
        if (icon != null) {
            int iconWidth = icon.getIconWidth();
            int iconHeight = icon.getIconHeight();

            double iconAspect = (double) iconHeight / iconWidth;

            int w = getWidth();
            int h = getHeight();
            double canvasAspect = (double) h / w;

            int x = 0, y = 0;

            // Maintain aspect ratio.
            if (iconAspect < canvasAspect) {
                // Drawing space is taller than image.
                y = h;
                h = (int) (w * iconAspect);
                y = (y - h) / 2; // center it along vertical
            } else {
                // Drawing space is wider than image.
                x = w;
                w = (int) (h / iconAspect);
                x = (x - w) / 2; // center it along horizontal
            }

            Image img = icon.getImage();
            g.drawImage(img, x, y, (w + x), (h + y), 0, 0, iconWidth, iconHeight, null);
            setMinimumSize(new Dimension(1, 1));
            g.dispose();
        }
    }
}
