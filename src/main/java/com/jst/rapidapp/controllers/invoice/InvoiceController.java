package com.jst.rapidapp.controllers.invoice;


import com.jst.rapidapp.beans.InvoiceHeader;
import com.jst.rapidapp.service.invoice.InvoiceHeaderService;
import com.jst.rapidapp.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vansales/invoice")
public class InvoiceController {

    @Autowired
    InvoiceHeaderService invoiceHeaderService;

    @Autowired
    ProductService productService;

    @PostMapping("/")
    public ResponseEntity<InvoiceHeader> saveInvoiceHeader(@RequestBody InvoiceHeader invoiceHeader){
        InvoiceHeader invoiceHeaderResponse = invoiceHeaderService.createInvoiceHeader(invoiceHeader);
        return new ResponseEntity<InvoiceHeader>(invoiceHeaderResponse,HttpStatus.OK);
    }

    @GetMapping("/{invoiceId}")
    public ResponseEntity<InvoiceHeader> getInvoiceHeaderById(@PathVariable long invoiceId){
        InvoiceHeader invoiceHeaderResponse = invoiceHeaderService.getInvoiceHeaderById(invoiceId);
        return new ResponseEntity<InvoiceHeader>(invoiceHeaderResponse,HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<InvoiceHeader>> getInvoiceHeaderList(){
        List<InvoiceHeader> invoiceHeaderResponse = invoiceHeaderService.getInvoiceHeaderList();
        return new ResponseEntity<List<InvoiceHeader>>(invoiceHeaderResponse,HttpStatus.OK);
    }

    @DeleteMapping("/{invoiceId}")
    public ResponseEntity <HttpStatus> deleteInvoiceHeaderByProductId(@PathVariable long invoiceId){
        invoiceHeaderService.deleteInvoiceHeader(invoiceId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{invoiceId}")
    public ResponseEntity <HttpStatus> updateInvoiceHeaderByProductId(@PathVariable long invoiceId, @RequestBody InvoiceHeader invoiceHeader){
        invoiceHeaderService.updateInvoiceHeader(invoiceId, invoiceHeader);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
