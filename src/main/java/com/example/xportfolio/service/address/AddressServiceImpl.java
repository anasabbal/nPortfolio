package com.example.xportfolio.service.address;


import com.example.xportfolio.command.AddressCommand;
import com.example.xportfolio.exception.BusinessException;
import com.example.xportfolio.exception.ExceptionPayloadFactory;
import com.example.xportfolio.model.Address;
import com.example.xportfolio.model.Writer;
import com.example.xportfolio.repository.AddressRepository;
import com.example.xportfolio.util.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService{

    private final AddressRepository addressRepository;

    @Override
    public Address findById(String addressId) {
        log.info("Begin fetching address with id {}", addressId);

        final Address address = addressRepository.findById(addressId).
                orElseThrow(() -> new BusinessException(ExceptionPayloadFactory.ADDRESS_NOT_FOUND.get()));
        log.info("fetching address with payload {} Done!" , JSONUtil.toJSON(address));
        return address;
    }
    @Override
    public Address updateAddress(String addressId, AddressCommand addressCommand) {
        final Address address = findById(addressId);
        address.update(addressCommand);

        return address;
    }
}
