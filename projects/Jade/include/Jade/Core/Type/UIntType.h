/*
 * Copyright (c) 2009, IETR/INSA of Rennes
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 *   * Redistributions of source code must retain the above copyright notice,
 *     this list of conditions and the following disclaimer.
 *   * Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *   * Neither the name of the IETR/INSA of Rennes nor the names of its
 *     contributors may be used to endorse or promote products derived from this
 *     software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY
 * WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 */

/**
@brief Description of the IntType class interface
@author Jerome Gorin
@file UIntType.h
@version 0.1
@date 22/03/2010
*/

//------------------------------
#ifndef UINTTYPE_H
#define UINTTYPE_H

#include "Jade/Core/Expression.h"

#include "Jade/Core/IRType.h"
//------------------------------

/**
 * @class UIntType
 *
 * This class defines an unsigned integer type.
 *
 * @author Jerome Gorin
 * 
 */
class UIntType : public IRType {
public:
	/*!
     *  @brief Constructor
     *
	 * Creates a new unsigned int type with the given size.
	 *
     * @param size : Expr of the size of this unsigned integer type
     */
	UIntType(Expr* size){this->size = size;};
	~UIntType();

	/**
	 * @brief Returns true if the current Type is UIntType
	 * 
	 * @return True if the Type is UIntType
	 */
	bool isUIntType(){return true;};

	/**
	 * @brief Returns the size of this type.
	 * 
	 * @return integer of the size
	 */
	int getSize(){return 32;};

private:
	Expr* size;

};

#endif