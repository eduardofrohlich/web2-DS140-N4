import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarFuncionarioComponent } from './listar-funcionario.component';

describe('ListarFuncionarioComponent', () => {
  let component: ListarFuncionarioComponent;
  let fixture: ComponentFixture<ListarFuncionarioComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListarFuncionarioComponent]
    });
    fixture = TestBed.createComponent(ListarFuncionarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
