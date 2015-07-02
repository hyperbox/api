/*
 * Hyperbox - Virtual Infrastructure Manager
 * Copyright (C) 2015 Maxime Dor
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

package io.kamax.helper.swing;

import io.kamax.tool.AxStrings;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class JTextFieldShadow extends JTextField {

   private static final Color SHADOW_COLOR = Color.LIGHT_GRAY;
   private String shadowText;
   private Color prevForeground;
   private boolean isShadow;

   public JTextFieldShadow(String shadowText) {
      super(shadowText);

      isShadow = true;
      setShadowText(shadowText);
      prevForeground = getForeground();
      setForeground(SHADOW_COLOR);

      this.addFocusListener(new FocusListener() {

         @Override
         public void focusGained(FocusEvent fe) {
            if (isShadow) {
               setText("");
               setLight();
            }
         }

         @Override
         public void focusLost(FocusEvent fe) {
            if (AxStrings.isEmpty(getText())) {
               setText(JTextFieldShadow.this.shadowText);
               isShadow = true;
               prevForeground = getForeground();
               setForeground(SHADOW_COLOR);
            }
         }
      });
   }

   private void setLight() {
      isShadow = false;
      setForeground(prevForeground);
   }

   @Override
   public String getText() {
      if (isShadow) {
         return null;
      } else {
         return super.getText();
      }
   }

   @Override
   public void setText(String t) {
      super.setText(t);
      setLight();
   }

   public void setShadowText(String shadowText) {
      this.shadowText = shadowText;
   }

}
