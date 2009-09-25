/*****************************************************************************
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2009 Sun Microsystems, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Sun designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Sun in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * Contributor(s):

 * The Original Software is the CVS Client Library.
 * The Initial Developer of the Original Software is Robert Greig.
 * Portions created by Robert Greig are Copyright (C) 2000.
 * All Rights Reserved.
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.

 * Contributor(s): Robert Greig.
 *****************************************************************************/
package org.netbeans.lib.cvsclient.request;

import java.io.*;

import org.netbeans.lib.cvsclient.connection.*;
import org.netbeans.lib.cvsclient.file.*;

/**
 * The superclass of all requests made to the CVS server
 * @author  Robert Greig
 */
public abstract class Request {
    /**
     * Get the request String that will be passed to the server
     * @return the request String
     * @throws UnconfiguredRequestException if the request has not been
     * properly configured
     */
    public abstract String getRequestString()
            throws UnconfiguredRequestException;

    /**
     * Is a response expected from the server?
     * @return true if a response is expected, false if no response if
     * expected
     */
    public abstract boolean isResponseExpected();

    /**
     * If a file transmission is required, get the file object representing
     * the file to transmit after the request string. The default
     * implementation returns null, indicating no file is to be transmitted
     * @return the file object, if one should be transmitted, or null if
     * no file object is to be transmitted.
     */
    public FileDetails getFileForTransmission() {
        return null;
    }

    /**
     * Modify streams on the connection if necessary
     */
    public void modifyOutputStream(Connection connection) throws IOException {
        // DO NOTHING
    }

    /**
     * Modify streams on the connection if necessary
     */
    public void modifyInputStream(Connection connection) throws IOException {
        // DO NOTHING
    }

    /**
     * Does this request modify the input stream?
     * @return true if it does, false otherwise
     */
    public boolean modifiesInputStream() {
        return false;
    }
}
