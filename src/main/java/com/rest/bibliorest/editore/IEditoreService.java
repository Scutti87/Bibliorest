package com.rest.bibliorest.editore;

import java.util.List;

public interface IEditoreService {

	EditoreDto getEditoreById(long id);

	List<EditoreDto> getListaEditori();
}
