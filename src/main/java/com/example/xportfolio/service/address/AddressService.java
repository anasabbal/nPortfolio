package com.example.xportfolio.service.address;

import com.example.xportfolio.command.AddressCommand;
import com.example.xportfolio.model.Address;

public interface AddressService {
    Address findById(String addressId);
    Address updateAddress(String addressId, AddressCommand addressCommand);
}
