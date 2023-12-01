import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalhesPedidoComponent } from './detalhes-pedido.component';

describe('DetalhesPedidoComponent', () => {
  let component: DetalhesPedidoComponent;
  let fixture: ComponentFixture<DetalhesPedidoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DetalhesPedidoComponent]
    });
    fixture = TestBed.createComponent(DetalhesPedidoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
