package com.example.xportfolio.service.address;


import com.example.xportfolio.command.AddressCommand;
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



}
