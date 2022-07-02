package com.example.xportfolio.controller;


import com.example.xportfolio.command.AddressCommand;
import com.example.xportfolio.dto.AddressDto;
import com.example.xportfolio.mapper.AddressMapper;
import com.example.xportfolio.model.Address;
import com.example.xportfolio.service.address.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.xportfolio.cons.ResourcePath.*;

@RestController
@RequestMapping(V1 + ADDRESS)
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;
    private final AddressMapper addressMapper;

    @GetMapping("{addressId}")
    public ResponseEntity<AddressDto> findById(@PathVariable("addressId") final String addressId){
        final Address address = addressService.findById(addressId);

        return ResponseEntity.ok(addressMapper.toAddressDto(address));
    }

    @PutMapping("{addressId}")
    public ResponseEntity<AddressDto> updateAddress(@PathVariable("addressId") final String addressId,
                                                    @RequestBody final AddressCommand addressCommand){
        final Address address = addressService.updateAddress(addressId, addressCommand);

        return ResponseEntity.ok(addressMapper.toAddressDto(address));
    }
}
