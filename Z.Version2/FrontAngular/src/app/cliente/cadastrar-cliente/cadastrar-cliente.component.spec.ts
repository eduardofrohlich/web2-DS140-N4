import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastrarClienteComponent } from './cadastrar-cliente.component';

describe('CadastrarClienteComponent', () => {
  let component: CadastrarClienteComponent;
  let fixture: ComponentFixture<CadastrarClienteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CadastrarClienteComponent]
    });
    fixture = TestBed.createComponent(CadastrarClienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
