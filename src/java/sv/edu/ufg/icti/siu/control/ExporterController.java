/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.icti.siu.control;

/**
 *
 * @author Melvin Caceres <macrsys@gmail.com>
 */
/*
 * Copyright 2011-2015 PrimeFaces Extensions
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * $Id$
 */



import java.io.Serializable;
import java.lang.Boolean;
import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;



/**
 * ExporterController
 *
 * @author  Sudheer Jonna / last modified by $Author$
 * @version $Revision$
 * @since   1.0
 */
//Control que se tomo de los showcase de extencion primefaces
//para incorporar mejoras en los reportes falta mucha tela que cortar
//pero el que se anime manos a la obra
@ManagedBean
@ApplicationScoped
public class ExporterController implements Serializable {

	private static final long serialVersionUID = 20120316L;

	private Boolean customExporter;


	public ExporterController() {
             customExporter=false;
	}

    public Boolean getCustomExporter() {
        return customExporter;
    }

    public void setCustomExporter(Boolean customExporter) {
        this.customExporter = customExporter;
    }
}
