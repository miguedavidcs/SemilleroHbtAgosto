/**
 * 
 */
package com.hbt.semillero.interfaces;

import com.hbt.semillero.dtos.CantidadDTO;
import com.hbt.semillero.dtos.ResultadoDTO;

/**
 * @author Usuario Miguel Castaño
 *
 */
public interface IGestionarCompraComic {

	ResultadoDTO comprarComic(CantidadDTO CantidadDTO) throws Exception;

}
