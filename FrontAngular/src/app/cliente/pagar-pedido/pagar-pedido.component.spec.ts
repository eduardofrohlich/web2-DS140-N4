import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PagarPedidoComponent } from './pagar-pedido.component';

describe('PagarPedidoComponent', () => {
  let component: PagarPedidoComponent;
  let fixture: ComponentFixture<PagarPedidoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PagarPedidoComponent]
    });
    fixture = TestBed.createComponent(PagarPedidoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
