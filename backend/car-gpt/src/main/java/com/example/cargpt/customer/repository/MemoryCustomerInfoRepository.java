package com.example.cargpt.customer.repository;

import com.example.cargpt.customer.domain.CustomerInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class MemoryCustomerInfoRepository implements CustomerInfoRepository {
    //일단 동시성 문제 배제
    private static Map<String, CustomerInfo> store = new HashMap<>();
//    private static long sequence = 0L;

    @Override
    public CustomerInfo save(CustomerInfo customer) {
//        customer.setCsmrMgmtNo(++sequence);
        store.put(customer.getCsmrMgmtNo(), customer);
        return customer;
    }

    @Override
    public Optional<CustomerInfo> findByCsmrMgmtNo(String csmrMgmtNo) {
        return Optional.ofNullable(store.get(csmrMgmtNo)); //Null일 가능성이 있으므로 Optional로 감싸서 반환
    }

    // test 끝나고 store 지울 수 있도록
    public void clearStore() {
        store.clear();
    }
}
