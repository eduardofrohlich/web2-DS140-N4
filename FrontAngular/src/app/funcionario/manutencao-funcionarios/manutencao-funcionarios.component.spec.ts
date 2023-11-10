import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManutencaoFuncionariosComponent } from './manutencao-funcionarios.component';

describe('ManutencaoFuncionariosComponent', () => {
  let component: ManutencaoFuncionariosComponent;
  let fixture: ComponentFixture<ManutencaoFuncionariosComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ManutencaoFuncionariosComponent]
    });
    fixture = TestBed.createComponent(ManutencaoFuncionariosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
