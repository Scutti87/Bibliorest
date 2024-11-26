package com.rest.bibliorest.operatore;

import java.util.List;

public interface IOperatoreService {

	OperatoreDto getOperatoreById(long id);

	List<OperatoreDto> getListaOperatori();
}
