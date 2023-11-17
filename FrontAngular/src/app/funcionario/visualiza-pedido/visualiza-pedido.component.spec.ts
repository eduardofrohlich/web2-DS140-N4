import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VisualizaPedidoComponent } from './visualiza-pedido.component';

describe('VisualizaPedidoComponent', () => {
  let component: VisualizaPedidoComponent;
  let fixture: ComponentFixture<VisualizaPedidoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [VisualizaPedidoComponent]
    });
    fixture = TestBed.createComponent(VisualizaPedidoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
