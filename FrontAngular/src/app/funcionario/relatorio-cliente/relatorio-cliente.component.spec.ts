import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RelatorioClienteComponent } from './relatorio-cliente.component';

describe('RelatorioClienteComponent', () => {
  let component: RelatorioClienteComponent;
  let fixture: ComponentFixture<RelatorioClienteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RelatorioClienteComponent]
    });
    fixture = TestBed.createComponent(RelatorioClienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
