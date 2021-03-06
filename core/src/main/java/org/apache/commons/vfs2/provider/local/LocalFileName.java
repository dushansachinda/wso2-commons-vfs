/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.vfs2.provider.local;

import org.apache.commons.vfs2.FileName;
import org.apache.commons.vfs2.FileType;
import org.apache.commons.vfs2.provider.AbstractFileName;

/**
 * A local file URI.
 *
 * @author <a href="http://commons.apache.org/vfs/team-list.html">Commons VFS team</a>
 * @version $Revision: 1035190 $ $Date: 2010-11-15 14:28:37 +0530 (Mon, 15 Nov 2010) $
 */
public class LocalFileName extends AbstractFileName
{
    private final String rootFile;

    protected LocalFileName(final String scheme,
                            final String rootFile,
                            final String path,
                            final FileType type)
    {
        super(scheme, path, type);
        this.rootFile = rootFile;
    }

    /**
     * Returns the root file for this file.
     * @return The root file name.
     */
    public String getRootFile()
    {
        return rootFile;
    }

    /**
     * Factory method for creating name instances.
     * @param path The file path.
     * @param type The file type.
     * @return The FileName.
     */
    @Override
    public FileName createName(final String path, FileType type)
    {
        return new LocalFileName(getScheme(), rootFile, path, type);
    }

    /**
     * Builds the root URI for this file name.
     */
    @Override
    protected void appendRootUri(final StringBuilder buffer, boolean addPassword)
    {
        buffer.append(getScheme());
        buffer.append("://");
        buffer.append(rootFile);
    }
}
