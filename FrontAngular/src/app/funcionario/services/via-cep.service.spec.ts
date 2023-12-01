/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { ViaCepService } from './via-cep.service';

describe('Service: ViaCep', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ViaCepService]
    });
  });

  it('should ...', inject([ViaCepService], (service: ViaCepService) => {
    expect(service).toBeTruthy();
  }));
});
