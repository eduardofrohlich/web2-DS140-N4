/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { RoupaService } from './roupa.service';

describe('Service: Roupa', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RoupaService]
    });
  });

  it('should ...', inject([RoupaService], (service: RoupaService) => {
    expect(service).toBeTruthy();
  }));
});
