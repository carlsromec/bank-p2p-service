package com.everis.bankp2pservice.model.document;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "CustomerBootCoinDoc")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerBootCoinDoc {
  
  @Id
  @NotEmpty
  private String id;
  @NotNull
  private String DNI;
  @NotNull
  private String email;
  @NotNull
  private String telephono;
  @Valid
  private TypeDocumentDoc typeDocumentDoc;
  
  public CustomerBootCoinDoc(@NotNull String dNI, @NotNull String email,
      @NotNull String telephono, @Valid TypeDocumentDoc typeDocumentDoc) {
    super();
    DNI = dNI;
    this.email = email;
    this.telephono = telephono;
    this.typeDocumentDoc = typeDocumentDoc;
  }
  
  

}
