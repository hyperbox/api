/*
 * Hyperbox - Virtual Infrastructure Manager
 * Copyright (C) 2015 Max Dor
 *
 * https://apps.kamax.io/hyperbox
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

package io.kamax.hbox.hypervisor.vbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class VirtualBox {

    public static final String VENDOR = "Oracle";
    public static final String PRODUCT = "VirtualBox";

    public static final String VBOX_ID = "vbox";

    public static final class Version {

        public static final String v4_2 = "4.2";
        public static final String v4_3 = "4.3";
        public static final String v5_0 = "5.0";
        public static final String v5_1 = "5.1";
        public static final String v5_2 = "5.2";
        public static final String v6_0 = "6.0";
        public static final String v6_1 = "6.1";

    }

    public static final class Type {

        public static final String XPCOM = "xpcom";
        public static final String MSCOM = "mscom";
        public static final String WEB_SERVICES = "ws";

    }

    public static final class ID {

        public static final String XPCOM_4_2 = VBOX_ID + "-" + Version.v4_2 + "-" + Type.XPCOM;
        public static final String MSCOM_4_2 = VBOX_ID + "-" + Version.v4_2 + "-" + Type.MSCOM;
        public static final String WS_4_2 = VBOX_ID + "-" + Version.v4_2 + "-" + Type.WEB_SERVICES;

        public static final String XPCOM_4_3 = VBOX_ID + "-" + Version.v4_3 + "-" + Type.XPCOM;
        public static final String MSCOM_4_3 = VBOX_ID + "-" + Version.v4_3 + "-" + Type.MSCOM;
        public static final String WS_4_3 = VBOX_ID + "-" + Version.v4_3 + "-" + Type.WEB_SERVICES;

        public static final String XPCOM_5_0 = VBOX_ID + "-" + Version.v5_0 + "-" + Type.XPCOM;
        public static final String MSCOM_5_0 = VBOX_ID + "-" + Version.v5_0 + "-" + Type.MSCOM;
        public static final String WS_5_0 = VBOX_ID + "-" + Version.v5_0 + "-" + Type.WEB_SERVICES;

        public static final String XPCOM_5_1 = VBOX_ID + "-" + Version.v5_1 + "-" + Type.XPCOM;
        public static final String MSCOM_5_1 = VBOX_ID + "-" + Version.v5_1 + "-" + Type.MSCOM;
        public static final String WS_5_1 = VBOX_ID + "-" + Version.v5_1 + "-" + Type.WEB_SERVICES;

        public static final String XPCOM_5_2 = VBOX_ID + "-" + Version.v5_2 + "-" + Type.XPCOM;
        public static final String MSCOM_5_2 = VBOX_ID + "-" + Version.v5_2 + "-" + Type.MSCOM;
        public static final String WS_5_2 = VBOX_ID + "-" + Version.v5_2 + "-" + Type.WEB_SERVICES;

        public static final String XPCOM_6_0 = VBOX_ID + "-" + Version.v6_0 + "-" + Type.XPCOM;
        public static final String MSCOM_6_0 = VBOX_ID + "-" + Version.v6_0 + "-" + Type.MSCOM;
        public static final String WS_6_0 = VBOX_ID + "-" + Version.v6_0 + "-" + Type.WEB_SERVICES;

        public static final String XPCOM_6_1 = VBOX_ID + "-" + Version.v6_1 + "-" + Type.XPCOM;
        public static final String MSCOM_6_1 = VBOX_ID + "-" + Version.v6_1 + "-" + Type.MSCOM;
        public static final String WS_6_1 = VBOX_ID + "-" + Version.v6_1 + "-" + Type.WEB_SERVICES;

    }

    public static final class ID_GROUP {

        public static final List<String> ALL_4_2 = Collections.unmodifiableList(
                Arrays.asList(
                        ID.XPCOM_4_2,
                        ID.MSCOM_4_2,
                        ID.WS_4_2
                ));

        public static final List<String> ALL_4_3 = Collections.unmodifiableList(
                Arrays.asList(
                        ID.XPCOM_4_3,
                        ID.MSCOM_4_3,
                        ID.WS_4_3
                ));

        public static final List<String> ALL_5_0 = Collections.unmodifiableList(
                Arrays.asList(
                        ID.XPCOM_5_0,
                        ID.MSCOM_5_0,
                        ID.WS_5_0
                ));

        public static final List<String> ALL_5_1 = Collections.unmodifiableList(
                Arrays.asList(
                        ID.XPCOM_5_1,
                        ID.MSCOM_5_1,
                        ID.WS_5_1
                ));

        public static final List<String> ALL_5_2 = Collections.unmodifiableList(
                Arrays.asList(
                        ID.XPCOM_5_2,
                        ID.MSCOM_5_2,
                        ID.WS_5_2
                ));

        public static final List<String> ALL_6_0 = Collections.unmodifiableList(
                Arrays.asList(
                        ID.XPCOM_6_0,
                        ID.MSCOM_6_0,
                        ID.WS_6_0
                ));

        public static final List<String> ALL_6_1 = Collections.unmodifiableList(
                Arrays.asList(
                        ID.XPCOM_6_1,
                        ID.MSCOM_6_1,
                        ID.WS_6_1
                ));


        public static final List<String> ALL = Collections.unmodifiableList(new ArrayList<String>() {

            private static final long serialVersionUID = -5601205639117721970L;

            {
                addAll(ALL_4_2);
                addAll(ALL_4_3);
                addAll(ALL_5_0);
                addAll(ALL_5_1);
                addAll(ALL_5_2);
                addAll(ALL_6_0);
                addAll(ALL_6_1);
            }

        });
    }

}
