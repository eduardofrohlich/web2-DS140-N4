import { TestBed } from '@angular/core/testing';

import { PedidoOnlineService } from './pedido-online.service';

describe('PedidoOnlineService', () => {
  let service: PedidoOnlineService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PedidoOnlineService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
