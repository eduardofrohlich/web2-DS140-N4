import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TelaInicialFuncComponent } from './tela-inicial-func.component';

describe('TelaInicialFuncComponent', () => {
  let component: TelaInicialFuncComponent;
  let fixture: ComponentFixture<TelaInicialFuncComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TelaInicialFuncComponent]
    });
    fixture = TestBed.createComponent(TelaInicialFuncComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
